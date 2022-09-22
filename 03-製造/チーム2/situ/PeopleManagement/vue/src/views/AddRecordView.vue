<template>
  <el-container style="height: 100vh;">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246); height: 100%">
      <el-menu :default-openeds="['1']" :default-active="this.$router.path" style="height: 100%"
               background-color="#545c64" text-color="#fff"
               active-text-color="#ffd04b" router>
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-menu"></i>勤怠管理</template>
          <el-menu-item-group>
            <template slot="title"></template>
            <el-menu-item index="/">ホーム</el-menu-item>
            <el-menu-item index="/details">詳細</el-menu-item>
            <el-menu-item index="/addrecord">登録</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="font-size: 12px">
        <el-descriptions style="margin-top: 6px" title="" :column="3" border>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-user"></i>
              社員ID
            </template>
            <span>{{employee_info.employee_id}}</span>
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-edit-outline"></i>
              氏名
            </template>
            <span>{{employee_info.employee_name}}</span>
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-office-building"></i>
              所属部門
            </template>
            <span>{{employee_info.department_name}}</span>
          </el-descriptions-item>
        </el-descriptions>
      </el-header>

      <el-main>
        <div class="breadcrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">ホーム</el-breadcrumb-item>
            <el-breadcrumb-item>詳細</el-breadcrumb-item>
            <el-breadcrumb-item>登録</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <div class="mt-10">
          <el-row :gutter="20">
            <el-col :span="12" :offset="6">
              <div class="grid-content">
                <el-form ref="form" :model="form" label-width="120px">
                  <el-form-item label="日付">
                    <el-date-picker
                        v-model="form.date"
                        type="date"
                        format="yyyy-MM-DD"
                        value-format="yyyy-MM-DD"
                        placeholder="日付選択"
                        @change="checkDate()">
                    </el-date-picker>
                  </el-form-item>
                  <el-form-item label="作業開始時間">
                    <el-time-picker
                        v-model="form.starttime"
                        placeholder="時間選択"
                        format="HH:mm"
                        value-format="HH:mm"
                        type="datetime"
                        @change="calculateWorkingTime()">
                    </el-time-picker>
                  </el-form-item>
                  <el-form-item label="作業終了時間">
                    <el-time-picker
                        v-model="form.endtime"
                        placeholder="時間選択"
                        format="HH:mm"
                        value-format="HH:mm"
                        type="datetime"
                        @change="calculateWorkingTime()">
                    </el-time-picker>
                  </el-form-item>
                  <el-form-item label="休憩時間">
                    <el-input v-model="form.resthours" @change="calculateWorkingTime()" placeholder="0" :disabled="this.futureDay"></el-input>
                  </el-form-item>
                  <el-form-item label="欠勤時間">
                    <el-input v-model="form.absencehours" @change="calculateWorkingTime()" placeholder="0" :disabled="this.futureDay"></el-input>
                  </el-form-item>
                  <el-form-item label="労働時間">
                    <el-input v-model="form.workinghours" placeholder="計算中..." :disabled="this.futureDay" readonly></el-input>
                  </el-form-item>
                  <el-form-item label="残業時間">
                    <el-input v-model="form.overtimehours" placeholder="計算中..."  :disabled="this.futureDay"readonly></el-input>
                  </el-form-item>
                  <el-form-item label="出勤状態">
                    <el-select v-model="form.type" placeholder="状態選択" @change="getSelectedOption()" value="form.type">
                      <el-option v-for="item in options" :key="item.value" :label="item.label"
                                 :value="item.value"></el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item label="作業内容">
                    <el-input type="textarea" v-model="form.workingdetails"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="onSubmit">登録</el-button>
                    <el-button @click="handleBack()">戻る</el-button>
                  </el-form-item>
                </el-form>
              </div>
            </el-col>
          </el-row>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>

export default {
  name: 'AddRecordView',

  data() {
    return {
      employee_info:{
        employee_id: '',
        employee_name: '',
        department_name: '',
      },
      form: {
        record_id: '',
        date: '',
        starttime: '',
        endtime: '',
        resthours: '',
        workinghours: '',
        overtimehours: '',
        type: '',
        absencehours: '',
        workingdetails: ''
      },
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
      options: [{
        value: 0,
        label: '出勤',
      }, {
        value: 1,
        label: '有給休暇',
      }, {
        value: 2,
        label: '特別休暇',
      }, {
        value: 3,
        label: '欠勤',
      }, {
        value: 9,
        label: 'その他',
      }],
      timeCalculation: {
        differentTime: '',
        differentHour: '',
        differentMinute: '',
      },
      futureDay : false,
    }
  },
  created() {
    this.getEmployeeInfo(10002);
  },
  methods: {
    onSubmit() {
      this.$axios.post("http://localhost:8090/attendances", this.form).then((res) => {
        if (res.data.flag) {
          this.$message.success("登録完了しました");
          this.$router.push({
            name: 'Details'
          })
        } else {
          this.$message.error("エラー、登録できません");
        }
      })
    },
    handleBack() {
      this.$router.push({
        name: 'Details'
      })
    },
    calculateWorkingTime() {
      let inputDate = this.form.date;
      let startTimeDate = new Date(inputDate + ' ' + this.form.starttime + ':00');
      let endTimeDate = new Date(inputDate + ' ' + this.form.endtime + ':00');
      let restHours = parseFloat(this.form.resthours).toFixed(1);
      let absenceHours = parseFloat(this.form.absencehours).toFixed(1);
      //console.log(inputDate, startTimeDate, endTimeDate, restHours, absenceHours);
      if (typeof inputDate == "undefined" || inputDate == null || inputDate === "" || typeof startTimeDate == "undefined" || startTimeDate == null || startTimeDate === "" || typeof endTimeDate == "undefined" || endTimeDate == null || endTimeDate === "" || typeof restHours == "undefined" || restHours == null || restHours === "" || typeof absenceHours == "undefined" || absenceHours == null || absenceHours === "") {
        return;
      }
      let calculateResult = endTimeDate.getTime() - startTimeDate.getTime();
      if (isNaN(calculateResult)) {
        console.log("Data error");
      } else {
        this.timeCalculation.differentHour = parseInt(Math.floor(calculateResult / (1000 * 60 * 60)));
        this.timeCalculation.defferentMinute = parseInt(Math.floor(((Math.floor(calculateResult / (1000 * 60 * 60))) - this.timeCalculation.differentHour) * 60));
        this.timeCalculation.differentTime = parseFloat(this.timeCalculation.differentHour + '.' + this.timeCalculation.defferentMinute).toFixed(1);
      }
      (Math.floor(this.timeCalculation.differentTime - restHours - absenceHours - 8)) > 0 ? (this.form.overtimehours = Math.floor(this.timeCalculation.differentTime - restHours - absenceHours - 8)) : (0);
      (Math.floor(this.timeCalculation.differentTime - restHours - absenceHours - this.form.overtimehours)) > 0 ? (this.form.workinghours = Math.floor(this.timeCalculation.differentTime - restHours - absenceHours)) : (0);

    },
    resetform() {
      this.form = {}
    },
    getSelectedOption(vId) {
      console.log();
    },
    getEmployeeInfo(employeeID){
      this.$axios.get("http://localhost:8090/employees/"+employeeID).then((res)=>{
        console.log(res.data);
        this.employee_info.employee_id = res.data.data.employee_id;
        this.employee_info.employee_name = res.data.data.employee_name;
        this.employee_info.department_name = res.data.data.dept_name;
      }).catch(err => console.log(err));
    },
    checkDate(){
      let nowDate = new Date();
      let iDate = new Date(this.form.date);
      console.log(nowDate, iDate);
      if (typeof iDate == "undefined" || iDate == null || iDate === "") {
        return;
      }
      if (iDate.getTime() - nowDate.getTime() > 0) {
        console.log("未来日です")
        this.futureDay = true;
      } else if (iDate.getTime() - nowDate.getTime() <= 0) {
        this.futureDay = false;
      }
    }
  }
}
</script>

<style>

.el-aside {
  color: #333;
}

.el-menu {
  border-right: none !important;
}

.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
</style>


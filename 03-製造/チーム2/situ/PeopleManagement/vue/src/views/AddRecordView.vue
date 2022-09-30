<template>
  <el-container style="height: 100vh;">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246); height: 100%">
      <el-menu :default-openeds="['1']" :default-active="$router.path" style="height: 100%"
               background-color="#545c64" text-color="#fff"
               active-text-color="#ffd04b" router>
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-menu"></i>勤怠管理</template>
          <el-menu-item-group>
            <template slot="title"></template>
            <el-menu-item index="/" class="menuItem">
              <router-link :to="{name: 'home', params: {employee_id:this.employee_info.employee_id}}" class="menuLink">
                一覧
              </router-link>
            </el-menu-item>
            <el-menu-item index="/details" class="menuItem">
              <router-link :to="{name: 'Details', params:{employee_id:this.employee_info.employee_id}}"
                           class="menuLink">詳細
              </router-link>
            </el-menu-item>
            <el-menu-item index="/addrecord" class="menuItem">
              <router-link :to="{name: 'Addrecord', params: {employee_id:this.employee_info.employee_id}}"
                           class="menuLink">登録
              </router-link>
            </el-menu-item>
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
            <span>{{ employee_info.employee_id }}</span>
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-edit-outline"></i>
              氏名
            </template>
            <span>{{ employee_info.employee_name }}</span>
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-office-building"></i>
              所属部門
            </template>
            <span>{{ employee_info.department_name }}</span>
          </el-descriptions-item>
        </el-descriptions>
      </el-header>

      <el-main>
        <div class="breadcrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">一覧</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/details' }">詳細</el-breadcrumb-item>
            <el-breadcrumb-item>登録</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <div class="mt-10">
          <el-row :gutter="20">
            <el-col :span="12" :offset="6">
              <div class="grid-content">
                <el-form ref="form" :model="form" label-width="120px">
                  <el-form-item label="日付" prop="attendance_date"
                                :rules="[{required: true, type:'string', message: '日付を選択してください', trigger: 'blur'}]">
                    <el-date-picker
                        v-model="form.attendance_date"
                        type="date"
                        format="yyyy-MM-dd"
                        value-format="yyyy-MM-dd"
                        placeholder="日付選択"
                        @change="checkDate()">
                    </el-date-picker>
                  </el-form-item>
                  <el-form-item label="作業開始時間">
                    <el-time-picker
                        v-model="form.start_time"
                        placeholder="時間選択"
                        format="HH:mm"
                        value-format="HH:mm"
                        type="datetime"
                        @change="calculateWorkingTime()">
                    </el-time-picker>
                  </el-form-item>
                  <el-form-item label="作業終了時間">
                    <el-time-picker
                        v-model="form.end_time"
                        placeholder="時間選択"
                        format="HH:mm"
                        value-format="HH:mm"
                        type="datetime"
                        @change="calculateWorkingTime()">
                    </el-time-picker>
                  </el-form-item>
                  <el-form-item label="休憩時間" prop="rest_hours"
                                :rules="[{min: 0, max: 24, type:'number', message: '入力時間は0-24だけです', trigger: 'blur'}]">
                    <el-input step="0.1" type="number" v-model.number="form.rest_hours" @change="calculateWorkingTime()"
                              placeholder="0"
                              :disabled="this.futureDay"></el-input>
                  </el-form-item>
                  <el-form-item label="欠勤時間" prop="absence_hours"
                                :rules="[{min: 0, max: 24, type:'number', message: '入力時間は0-24だけです', trigger: 'blur'}]">
                    <el-input step="0.1" type="number" v-model.number="form.absence_hours"
                              @change="calculateWorkingTime()" placeholder="0"
                              :disabled="this.futureDay"></el-input>
                  </el-form-item>
                  <el-form-item label="労働時間">
                    <el-input type="number" v-model.number="form.working_hours"
                              :placeholder="checkFutureDate" :disabled="this.futureDay"
                              readonly></el-input>
                  </el-form-item>
                  <el-form-item label="残業時間">
                    <el-input type="number" v-model.number="form.overtime_hours"
                              :placeholder="checkFutureDate" :disabled="this.futureDay"
                              readonly></el-input>
                  </el-form-item>
                  <el-form-item label="出勤状態">
                    <el-select v-model="form.working_status_id" placeholder="状態選択"
                               value="form.type">
                      <el-option v-for="item in options" :key="item.value" :label="item.label"
                                 :value="item.value"></el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item label="作業内容" prop="working_details"
                                :rules="[{min: 0, max: 200, type:'string', message: '入力内容は0-200だけです', trigger: 'blur'}]">
                    <el-input type="textarea" v-model="form.working_details"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="onSubmit('form')">登録</el-button>
                    <el-button type="info" @click="handleBack()">戻る</el-button>
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
      employee_info: {
        employee_id: '',
        employee_name: '',
        department_name: '',
      },
      form: {
        record_id: '',
        attendance_date: '',
        start_time: '',
        end_time: '',
        rest_hours: '',
        working_hours: '',
        overtime_hours: '',
        working_status_id: '',
        absence_hours: '',
        working_details: '',
        create_date: '',
        create_user_id: '',
        update_date:'',
        update_user_id:'',
        flow_status_id: '',
        rec_del_flg:''
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
      futureDay: false,
      tempId: 1,
    }
  },
  created() {
    if (this.$route.params.employee_id != null) {
      this.employee_info.employee_id = this.$route.params.employee_id;
    } else {
      this.employee_info.employee_id = 10001;
    }
    this.getEmployeeInfo(this.employee_info.employee_id);
  },
  methods: {
    onSubmit(formName) {
      if (this.form.attendance_date != null || this.form.attendance_date !== "" || this.form.attendance_date !== undefined) {
        this.form.record_id = this.employee_info.employee_id + (this.form.attendance_date).replace(/-/g, '') + ((this.tempId < 10) ? ("0" + this.tempId) : this.tempId);
        this.tempId++;
        this.form.create_user_id = this.employee_info.employee_id;
        this.form.update_user_id = this.employee_info.employee_id;
        this.form.create_date = new Date();
        this.form.update_date = new Date();
        this.form.rec_del_flg = 0;
        this.form.flow_status_id = 0;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios.post("http://localhost:8090/attendances", this.form).then((res) => {
              if (res.data.flag) {
                this.$message.success("登録完了しました");
                this.$router.push({
                  name: 'home',
                  params: {
                    employee_id: this.employee_info.employee_id,
                  }
                })
              } else {
                this.$message.error("エラー、登録できません");
              }
            })
          } else {
            this.$message.error("エラー、フォームに必要データがありません。データを入力してください。");
            return false;
          }
        });
      }
    },
    handleBack() {
      this.$router.push({
        name: 'Details',
        params: {
          employee_id: this.employee_info.employee_id,
        }
      })
    },
    calculateWorkingTime() {
      let inputDate = this.form.attendance_date;
      let startTimeDate = new Date(inputDate + ' ' + this.form.start_time + ':00');
      let endTimeDate = new Date(inputDate + ' ' + this.form.end_time + ':00');
      let restHours = parseFloat(this.form.rest_hours).toFixed(1);
      let workingHours = 8;
      let absenceHours = parseFloat(this.form.absence_hours).toFixed(1);
      if (typeof inputDate == "undefined" || inputDate == null || inputDate === "" || typeof startTimeDate == "undefined" || startTimeDate == null || startTimeDate === "" || typeof endTimeDate == "undefined" || endTimeDate == null || endTimeDate === "" || typeof restHours == "undefined" || restHours == null || restHours === "" || typeof absenceHours == "undefined" || absenceHours == null || absenceHours === "") {
        return;
      }

      let calculateResult = endTimeDate.getTime() - startTimeDate.getTime();
      if (calculateResult < 0) {
        this.$message.error("エラー、終了時間 ＜ 開始時間");
        return;
      }
      if (isNaN(calculateResult)) {
        console.log("Data error");
      } else {
        this.timeCalculation.differentHour = parseInt(Math.floor(calculateResult / (1000 * 60 * 60)));
        this.timeCalculation.defferentMinute = parseInt(Math.floor(((Math.floor(calculateResult / (1000 * 60 * 60))) - this.timeCalculation.differentHour) * 60));
        this.timeCalculation.differentTime = parseFloat(this.timeCalculation.differentHour + '.' + this.timeCalculation.defferentMinute).toFixed(1);
      }
      this.form.working_hours = workingHours;
      (Math.floor(this.timeCalculation.differentTime - restHours - absenceHours - workingHours)) > 0 ? (this.form.overtime_hours = Math.floor(this.timeCalculation.differentTime - restHours - absenceHours - workingHours)) : (this.form.overtime_hours = 0);
      (Math.floor(this.timeCalculation.differentTime - restHours - absenceHours - this.form.overtime_hours)) > 0 ? (this.form.working_hours = (Math.floor(this.timeCalculation.differentTime - restHours - absenceHours)) > 8 ? 8 : Math.floor(this.timeCalculation.differentTime - restHours - absenceHours)) : (this.form.working_hours = 0);

    },
    resetform() {
      this.form = {}
    },
    getEmployeeInfo(employeeID) {
      this.$axios.get("http://localhost:8090/employees/" + employeeID).then((res) => {
        this.employee_info.employee_id = res.data.data.employee_id;
        this.employee_info.employee_name = res.data.data.employee_name;
        this.employee_info.department_name = res.data.data.dept_name;
      }).catch(err => console.log(err));
    },
    checkDate() {
      let nowDate = new Date();
      let iDate = new Date(this.form.attendance_date);
      if (typeof iDate == "undefined" || iDate == null) {
        return;
      }
      if (iDate.getTime() - nowDate.getTime() > 0) {
        //未来日です
        this.futureDay = true;
      } else if (iDate.getTime() - nowDate.getTime() <= 0) {
        this.futureDay = false;
      }
    },
  },
  computed: {
    checkFutureDate() {
      return this.futureDay ? '0' : '計算中...';
    },
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

.menuLink {
  width: 100%;
  display: block;
  height: 100%;
  text-decoration: none;
  color: white;
}

.menuItem {
  padding-right: 0 !important;
}
</style>


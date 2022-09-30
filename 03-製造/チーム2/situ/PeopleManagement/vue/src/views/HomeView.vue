<template>
  <el-container style="height: 100vh;">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246); height: 100%">
      <el-menu :router="true" :default-openeds="['1']" :default-active="this.$router.path" style="height: 100%"
               background-color="#545c64"
               text-color="#fff"
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
              <router-link :to="{name: 'Addrecord', params:{employee_id:this.employee_info.employee_id}}"
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
          </el-breadcrumb>
        </div>

        <div style="margin-top: 50px">
          <div class="searchBox floatLeft">
            <div class="block">
              <span class="demonstration"></span>
              <el-date-picker
                  v-model="selectedYear"
                  type="year"
                  :pickerOptions="pickerOptions"
                  placeholder="年選択"
                  format="yyyy"
                  value-format="yyyy">
              </el-date-picker>
              <el-button class="ml-5" type="primary" icon="el-icon-search" @click="getAttendanceData()">検索</el-button>
            </div>
          </div>
          <div class="goBack floatRight">
            <el-button class="ml-5" type="info" @click="handleBack()">ログアウト</el-button>
          </div>
          <div class="cleanBoth">
          </div>
        </div>
          <el-table :data="monthData" show-summary stripe border style="width: 100%" class="mt-20">
            <el-table-column prop="attendance_ym" align="center" label="月">
              <template v-slot="monthsScope">
                <el-button type="text" size="medium" @click="searchTargetMonthData(monthsScope.row)">
                  {{ monthsScope.row.attendance_ym | converMonth }}
                </el-button>
              </template>
            </el-table-column>
            <el-table-column prop="working_days" align="center" label="営業日数">
              <template v-slot="daysScope"><span>{{ daysScope.row.attendance_ym | calculateMonthDays(that) }}</span>
              </template>
            </el-table-column>
            <el-table-column prop="attendance_days" align="center" label="出勤日数">
            </el-table-column>
            <el-table-column prop="absence_days" align="center" label="欠勤日数">
            </el-table-column>
            <el-table-column prop="attendance_hours" align="center" label="実働時間">
            </el-table-column>
            <el-table-column prop="overtime_hours" align="center" label="残業時間">
            </el-table-column>
            <el-table-column prop="comments" align="center" label="コメント">
            </el-table-column>
          </el-table>

      </el-main>
    </el-container>
  </el-container>
</template>

<script>
// @ is an alias to /src


export default {
  name: 'HomeView',
  filters: {
    converMonth(value) {
      if (value != null) {
        return value.substring(4);
      }
    },
    calculateMonthDays(value, that) {
      if (value != null) {
        let currentMonth = value.substring(4);
        while (currentMonth.charAt(0) === '0') {
          currentMonth = currentMonth.substring(1);
        }
        let year = parseInt(that.selectedYear);
        let month = parseInt(currentMonth);
        let firstDate = 1;
        let lastDate = new Date(year, month, 0).getDate();
        let first = new Date(year, month - 1, firstDate).getTime();
        let last = new Date(year, month - 1, lastDate).getTime();
        let count = 0;
        for (let j = first; j <= last; j += 24 * 3600 * 1000) {
          let workDay = new Date(j);
          if (workDay.getDay() >= 1 && workDay.getDay() <= 5) {
            count++;
          }
        }
        return count;
      }
    }
  },
  data() {
    return {
      employee_info: {
        employee_id: '',
        employee_name: '',
        department_name: '',
        message: 'ログアウトしました',
      },
      monthData: [],
      working_days: '',
      attendance_days: '',
      absence_days: '',
      attendance_hours: '',
      overtime_hours: '',
      comments: '',
      selectedYear: '',
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
      that: this,
    }
  },
  created() {
    if (this.$route.params.employee_id != null) {
      this.employee_info.employee_id = this.$route.params.employee_id;
    } else {
      this.employee_info.employee_id = 10001;
    }
    this.getEmployeeInfo(this.employee_info.employee_id);
    this.selectedYear = (new Date().getFullYear()).toString();
    this.getAttendanceData();

  },
  methods: {
    getEmployeeInfo(employeeID) {
      this.$axios.get("http://localhost:8090/employees/" + employeeID).then((res) => {
        this.employee_info.employee_id = res.data.data.employee_id;
        this.employee_info.employee_name = res.data.data.employee_name;
        this.employee_info.department_name = res.data.data.dept_name;
      }).catch(err => console.log(err));
    },
    getAttendanceData() {
      this.$axios.get("http://localhost:8090/lists?year=" + this.selectedYear + "&employee_id=" + this.employee_info.employee_id).then((res) => {
        this.monthData = res.data.data;
      }).catch(err => console.log(err));
    },
    searchTargetMonthData(row) {
      this.$router.push({
        name: 'Details',
        params: {
          attendance_ym: row.attendance_ym,
          employee_id: this.employee_info.employee_id,
        }
      })
    },
    handleBack() {
      this.$router.push({
        name: 'Login',
        params: {
          message: this.employee_info.message,
        }
      })
    },
  },
  computed: {},
}
</script>

<style>
el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

el-aside {
  color: #333;
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

.searchBox, .goBack {
  margin: 10px 0;
}
</style>

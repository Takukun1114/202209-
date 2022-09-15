<template>
  <el-container style="height: 100vh;">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246); height: 100%">

      <el-menu :default-openeds="['1']" :default-active="this.$router.path" style="height: 100%" background-color="#545c64" text-color="#fff"
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
        <div style="text-align: right;">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>View</el-dropdown-item>
              <el-dropdown-item>Add</el-dropdown-item>
              <el-dropdown-item>Delete</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>Ben</span>
        </div>
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
                      placeholder="日付選択">
                  </el-date-picker>
                </el-form-item>
                <el-form-item label="作業開始時間">
                  <el-time-picker
                      v-model="form.starttime"
                      :picker-options="{selectableRange: '00:00:00 - 00:00:00'}"
                      placeholder="時間選択"
                      format="yyyy-MM-dd HH:mm"
                      value-format="yyyy-MM-dd HH:mm:ss"
                      type="datetime">
                  </el-time-picker>
                </el-form-item>
                <el-form-item label="作業終了時間">
                  <el-time-picker
                      v-model="form.endtime"
                      :picker-options="{selectableRange: '00:00:00 - 00:00:00'}"
                      placeholder="時間選択"
                      format="yyyy-MM-dd HH:mm"
                      value-format="yyyy-MM-dd HH:mm:ss"
                      type="datetime">
                  </el-time-picker>
                </el-form-item>
                <el-form-item label="休憩時間">
                  <el-input v-model="form.resthours"></el-input>
                </el-form-item>
                <el-form-item label="労働時間">
                  <el-input v-model="form.workinghours" readonly></el-input>
                </el-form-item>
                <el-form-item label="残業時間">
                  <el-input v-model="form.overtimehours" readonly></el-input>
                </el-form-item>
                <el-form-item label="欠勤時間">
                  <el-input v-model="form.absencehours"></el-input>
                </el-form-item>
                <el-form-item label="出勤状態">
                  <el-select v-model="form.type" placeholder="" value="">
                    <el-option label="出勤" value="work"></el-option>
                    <el-option label="有給休暇" value="rest"></el-option>
                    <el-option label="特別休暇" value="specialrest"></el-option>
                    <el-option label="欠勤" value="absence"></el-option>
                    <el-option label="その他" value="others"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="作業内容">
                  <el-input type="textarea" v-model="form.workingdetails"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="onSubmit">登録</el-button>
                  <el-button>戻る</el-button>
                </el-form-item>
              </el-form>
            </div></el-col>
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
      form: {
        date: '',
        starttime: '',
        endtime: '',
        resthours: '',
        workinghours: '',
        overtimehours: '',
        type: [],
        absencehours: '',
        workingdetails: ''
      },
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
      value1: '',
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
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


<template>
  <body id="login-page">
  <el-form class="login-container" :model="loginForm" labelPosition="top" label-width="120px">
    <h3 class="login_title">システムログイン</h3>
    <el-form-item prop="employeeId">
      <el-input
          type="text"
          v-model="loginForm.employee_id"
          auto-complete="off"
          placeholder="ユーザーID"
      ></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input
          type="password"
          v-model="loginForm.password"
          auto-complete="off"
          placeholder="パスワード"
      ></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button
          type="primary"
          style="width: 100%;  border: none"
          @click="login()"
      >ログイン
      </el-button>
    </el-form-item>
  </el-form>
  </body>
</template>


<script>
export default {
  name: 'Login',
  data() {
    return {
      loginForm: {
        employee_id: '',
        password: ''
      },
      responseResult: []
    }
  },
  created() {
    this.checkStatus();
  },
  methods: {
    login() {
      this.$axios
          .post('http://localhost:8090/api/login', {
            employee_id: this.loginForm.employee_id,
            password: this.loginForm.password
          })
          .then(res => {
            if (res.data.code === 200) {
              this.$message.success("ログインしました");
              this.$router.push({
                name: 'home',
                params: {
                  employee_id: this.loginForm.employee_id
                }
              })
            } else if (res.data.code === 401) {
              this.$message.error(res.data.message)
            } else if (res.data.code === 400) {
              this.$message.error(res.data.message)
            }
          })
          .catch(err => console.log(err))
    },
    checkStatus(){
      if (this.$route.params.message != null){
        this.$message.info(this.$route.params.message);
      }
    },
  }
}
</script>

<style scoped>
#login-page {
  background-image: url("../assets/img/bg.jpg");
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

body {
  margin: 0;
}

.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0 auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>

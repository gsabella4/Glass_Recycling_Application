<template>
  <h1>Logout</h1>
</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push('/login');
    //added below as a workaround for user logout not working
    this.$router.go(0);
  }
};
</script>

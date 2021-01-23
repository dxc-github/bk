<template>
  <div class="breadcrumb-parent">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: this.$route.fullPath }">{{this.$route.name}}</el-breadcrumb-item>
    </el-breadcrumb>
    <el-divider></el-divider>
  </div>
</template>

<script>
export default {
    props:[
        
    ],
    data(){
        return {
            // menu:{
            //     menuName:"文章",
            //     menuUrl:"/pagelist"
            // }
        }
    },
    mounted(){
        // console.log(this)
    }
};
</script>
<style>
.breadcrumb-parent{
    background: white;
    padding: 20px 15px;
    width: 930px;
    height: 60px;
}
</style>
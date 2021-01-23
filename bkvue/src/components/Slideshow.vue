<template>
  <div id="slideshow-parent">
    <el-carousel indicator-position="outside">
      <el-carousel-item v-for="item in imglist" :key="item">
        <img :src="item" width="960px" height="300px" />
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      imglist: [
        require("../assets/slideshow/1.jpg"),
        require("../assets/slideshow/2.jpg"),
        require("../assets/slideshow/3.jpg"),
      ],
    };
  },
};
</script>

<style>
#slideshow-parent {
  background: white;
  width: 960px;
  height: 300px;
}
</style>
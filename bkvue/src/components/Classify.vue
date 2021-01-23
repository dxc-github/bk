<template>
  <div class="classify-parent">
    <div class="classify-title">分类</div>
    <div class="classify-content">
      <span
        class="classify-content-item"
        v-for="(item, i) in Pageclass"
        :key="i"
      >
        <el-link :underline="false" :href="'/articles?classid=' + item.classId">
          {{ item.className }}
        </el-link>
      </span>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      Pageclass: [
      ],
    };
  },
  mounted: function () {
    this.getClassifyList();
  },
  methods: {
    getClassifyList: function () {
      this.$api.getClassList().then((data) => {
        console.log(data);
        this.Pageclass = data.result;
      });
    },
  },
};
</script>
<style lang="less">
.classify-parent {
  background: white;
  margin: 10px 0px;
  padding: 10px 0px;
  width: 300px;
  height: 156px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.classify-title {
  margin: 0px 10px 15px 15px;
  font-size: 15px;
  padding: 5px 0px;
  border-bottom: 0.5px solid rgb(160, 160, 160);
}
.classify-content {
  margin: 10px 15px;
  word-wrap: break-word;
  word-break: break-all;
  span {
    text-align: center;
    padding: 2px;
  }
}
</style>
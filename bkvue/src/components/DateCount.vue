<template>
  <div class="dateCount-parent">
    <div class="dateCount-title">归档统计</div>
    <div class="dateCount-content">
      <span
        class="dateCount-content-item"
        v-for="(item, i) in dateCount"
        :key="i"
      >
        <el-link :underline="false" :href="'/articles?date=' + item.updateDate">
          {{ item.updateDate }}({{item.articleTotal}})
        </el-link>
      </span>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dateCount: [],
    };
  },
  mounted: function () {
    this.getDateList();
  },
  methods: {
    getDateList: function () {
      this.$api.getArticleDateTotal().then((data) => {
        console.log(data);
        this.dateCount = data.result;
      });
    },
  },
};
</script>

<style lang="less">
.dateCount-parent {
  background: white;
  margin: 10px 0px;
  padding: 10px 0px;
  width: 300px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.dateCount-title {
  margin: 0px 10px 15px 15px;
  font-size: 15px;
  padding: 5px 0px;
  border-bottom: 0.5px solid rgb(160, 160, 160);
}
.dateCount-content {
  margin: 10px 15px;
  word-wrap: break-word;
  word-break: break-all;
  span {
    text-align: center;
    margin: 5px 3px;
  }
}
</style>
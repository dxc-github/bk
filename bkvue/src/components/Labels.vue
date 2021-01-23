<template>
  <div class="labels-parent">
    <div class="labels-title">标签</div>
    <div class="labels-content">
      <span class="labels-content-item" v-for="(item, i) in labelList" :key="i">
        <el-tag :key="item.labelName" :type="item.labelType" effect="dark">
          <a :href="'/articles?labelid=' + item.labelId"
            >{{ item.labelName }}({{ item.articleTotal }})</a
          >
        </el-tag>
      </span>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      labelList: [],
    };
  },
  mounted: function () {
    this.getLabelList();
  },
  methods: {
    getLabelList: function () {
      this.$api.getLabelList().then((data) => {
        console.log(data);
        this.labelList = data.result;
      });
    },
  },
};
</script>

<style lang="less">
.labels-parent {
  background: white;
  margin: 10px 0px;
  padding: 10px 0px;
  width: 300px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.labels-title {
  margin: 0px 10px 15px 15px;
  font-size: 15px;
  padding: 5px 0px;
  border-bottom: 0.5px solid rgb(160, 160, 160);
}
.labels-content {
  margin: 10px 15px;
  word-wrap: break-word;
  word-break: break-all;
  span {
    text-align: center;
    margin: 5px 3px;
    a,
    a:hover,
    a:active {
      text-decoration: none;
      color: white;
      font-size: 13px;
      font-weight:bold;
    }
  }
}
</style>
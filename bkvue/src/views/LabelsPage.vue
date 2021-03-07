<template>
  <div class="labelspage-parent">
    <div class="labelspage-breadcrumb">
      <breadcrumb></breadcrumb>
    </div>
    <div class="labelspage-label">
      <span class="labels-content-item" v-for="(item, i) in labelList" :key="i">
        <el-tag :key="item.labelName" :type="item.labelType" effect="dark">
          <a :href="'/list?label=' + item.labelName"
            >{{ item.labelName }}({{ item.articleTotal }})</a
          >
        </el-tag>
      </span>
    </div>
  </div>
</template>

<script>
import breadcrumb from "../components/Breadcrumb";

export default {
  components: { breadcrumb },
  data() {
    return {
      labelList: [],
    };
  },
  mounted:function(){
    this.getLabelList()
  },
  methods: {
    getLabelList: function () {
      this.$api.getLabelList().then((data) => {
        console.log(data);
        this.labelList = data.result;
      });
    }
  },
};
</script>

<style lang="less">
.labelspage-label {
  background: white;
  padding: 10px 15px;
  margin: 10px 0;
  width: 930px;
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
      font-weight: bold;
    }
  }
}
</style>
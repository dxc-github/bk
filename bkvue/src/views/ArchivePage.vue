<template>
  <div class="archivepage-parent">
    <div class="archivepage-breadcrumb">
      <breadcrumb></breadcrumb>
    </div>
    <div class="archivepage-timeline">
      <el-timeline>
        <el-timeline-item
          :timestamp="item.updateTime"
          placement="top"
          v-for="(item, i) in articlelist"
          :key="i"
        >
          <el-card>
            <h4>
              <a :href="'article?id='+item.articleId">{{ item.title }}</a>
            </h4>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </div>
</template>

<script>
import breadcrumb from "../components/Breadcrumb";

export default {
  components: {
    breadcrumb,
  },
  data() {
    return {
      articlelist: [],
    };
  },
  mounted:function(){
    this.getArticleList();
  },
  methods:{
    getArticleList:function(){
      this.$api.getRecommendList().then(data=>{
        console.log(data)
        this.articlelist=data.result.articleVoList
      })
    }
  }
};
</script>
<style lang="less">
.archivepage-timeline {
  background: white;
  width: 930px;
  padding: 10px 15px;
  margin: 10px 0;
}
.archivepage-timeline {
  a {
    text-decoration: none;
    color: black;
  }
}
</style>
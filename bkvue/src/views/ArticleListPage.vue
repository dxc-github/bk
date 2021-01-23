<template>
  <div class="articlelistpage-parent">
    <div class="articlelistpage-breadcrumb">
      <breadcrumb></breadcrumb>
    </div>
    <div class="articlelistpage-pages" v-if="articlelist">
      <synopsis :articlelist="articlelist"></synopsis>
    </div>
    <div class="articlelistpage-pagination" v-if="defaultpage">
      <pagination
        :pagesize="pagesize"
        :total="total"
        :defaultpage="defaultpage"
      ></pagination>
    </div>
  </div>
</template>

<script>
import breadcrumb from "../components/Breadcrumb";
import synopsis from "../components/Synopsis";
import pagination from "../components/Pagination";

export default {
  components: {
    breadcrumb,
    synopsis,
    pagination,
  },
  data() {
    return {
      type:1,
      pagesize: 2,
      total: 0,
      defaultpage: "1",
      currentpage: 1,
      articlelist: [
      ],
    };
  },
  mounted: function () {
    if(this.$route.query.labelid!=undefined){
      this.getArticleListByLabelId()
      this.type=2
    }else if(this.$route.query.classid!=undefined){
      this.getArticleListByClassId()
      this.type=3
    }else if(this.$route.query.date!=undefined){
      this.getArticleListByDate()
      this.type=4
    }else{
      this.getArticleList();
    }
    console.log(this.type)
  },
  methods: {
    CurrentChange(page) {
      this.currentpage = parseInt(page);
      console.log(this.type);
      if(this.type==2){
        this.getArticleListByLabelId()
      }else if(this.type==3){
        this.getArticleListByClassId()
      }else if(this.type==4){
        this.getArticleListByDate()
      }else{
        this.getArticleList();
      }
    },
    getArticleList: function () {
      this.$api
        .getArticleList({
          pageIndex: this.currentpage,
          pageSize: this.pagesize,
        })
        .then((data) => {
          console.log(data);
          this.articlelist = data.result.articleVoList;
          this.total = data.result.total;
        });
    },
    getArticleListByClassId: function () {
      this.$api
        .getArticleListByClass(this.$route.query.classid, {
          pageIndex: this.currentpage,
          pageSize: this.pagesize,
        })
        .then((data) => {
          console.log(data);
          this.articlelist = data.result.articleVoList;
          this.total = data.result.total;
        });
    },
    getArticleListByLabelId: function () {
      this.$api
        .getArticleListByLabel(this.$route.query.labelid, {
          pageIndex: this.currentpage,
          pageSize: this.pagesize,
        })
        .then((data) => {
          console.log(data);
          this.articlelist = data.result.articleVoList;
          this.total = data.result.total;
        });
    },
    getArticleListByDate: function () {
      this.$api
        .getArticleListByDate(this.$route.query.date, {
          pageIndex: this.currentpage,
          pageSize: this.pagesize,
        })
        .then((data) => {
          console.log(data);
          this.articlelist = data.result.articleVoList;
          this.total = data.result.total;
        });
    },
  },
};
</script>


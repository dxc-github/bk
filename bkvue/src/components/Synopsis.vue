<template>
  <div id="synopsis-parent">
    <div class="synopsis-item" v-for="(item, i) in articlelist" :key="i">
      <el-tag size="small" type="danger" effect="dark">{{
        item.classify.className
      }}</el-tag>
      <!-- <h4>{{item.title}}</h4> -->
      <span class="item_title">{{ item.title }}</span>
      <div class="synopsis-content">{{ item.contextSynopsis }}</div>
      <div class="synopsis-label">
        <p>
          <i class="el-icon-collection-tag"></i>
          <span v-for="(itemlabel, j) in item.labels" :key="j">
            <a :href="'/articles?labelid='+itemlabel.labelId">{{ itemlabel.labelName }} </a>
          </span>
          <i class="el-icon-edit"></i>
          {{ item.createTime }}
          <i class="el-icon-view"></i>
          {{ item.viewCount }}
        </p>
      </div>
    </div>
    <!-- <pagination :pagesize="pagesize" :total="total"></pagination> -->
  </div>
</template>

<script>
import Pagination from "./Pagination.vue";

export default {
  props: [
    "articlelist"
  ],
  components: {
    Pagination,
  },
  data() {
    return {
      
    };
  },
  methods: {
    // beforeCreate: function () {
    //   console.log("aaaaaaaaaa");
    //   this.CurrentChange(0, 1);
    // },
    // CurrentChange(pageSize, choosePage) {
    //   console.log(pageSize);
    //   console.log(choosePage);
    //   if (choosePage != "" && choosePage != undefined) {
    //     this.page = choosePage;
    //   }
    //   if (this.page == "1") {
    //     this.articleList = this.chooselist1;
    //   } else if (this.page == "2") {
    //     this.articleList = this.chooselist2;
    //   } else {
    //     console.log(this.articleList);
    //   }
    // },
  },
};
</script>

<style lang="less">
.synopsis-item {
  background: white;
  width: 920px;
  margin-top: 10px;
  padding: 20px;
  word-wrap: break-word;
  word-break: break-all;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}
.synopsis-content {
  height: 120px;
  margin: 10px;
}
.synopsis-label {
  text-align: right;
  span {
    margin-left: 2px;
    a {
      text-decoration: none;
    }
  }
}
.item_title {
  margin-left: 10px;
}
.el-tag el-tag--danger el-tag--small el-tag--dark {
  font-size: 20px;
}
</style>
<template>
    <div class="classifypage-parent">
        <div class="classifypage-breadcrumb">
            <breadcrumb></breadcrumb>
        </div>
        <div class="classifypage-class">
            <div class="classifypage-class-item" v-for="(item,i) in articlelist" :key="i">
                <div class="className">
                    <h2>
                        <a :href="'articles?classid='+item.classId">{{item.className}}</a>
                    </h2>
                </div>
                <div class="classArticle">
                    <p v-for="(pitem,j) in item.articles" :key="j">
                        <a :href="'article?id='+pitem.articleId">{{pitem.updateTime}} {{pitem.title}}</a>
                    </p>
                    <p><a :href="'articles?classid='+item.classId">更多内容...</a></p>
                </div>
                <!-- <el-divider></el-divider> -->
            </div>
        </div>
    </div>
</template>

<script>
import breadcrumb from "../components/Breadcrumb";
import Breadcrumb from '../components/Breadcrumb.vue';

export default {
  components: { Breadcrumb },
  data(){
      return {
          articlelist:[
              {     
                  classId:0,
                  className:"",
                  articles:[]
              }
          ]
      }
  },
  mounted:function(){
      this.getclassgroup()
  },
  methods:{
      getclassgroup:function(){
          this.$api.getClassGroup()
          .then((data)=>{
              this.articlelist=data.result
              console.log(data)
          });
      }
  }
    
}
</script>

<style lang="less">
.classifypage-class{
    background: white;
    width: 930px;
    padding: 10px 15px;
    margin: 10px 0;
}
.classifypage-class-item{
    // height: 250px;
    border-bottom: 1px solid rgb(230, 230, 230);
    overflow:hidden;
    a:link{
        text-decoration:none;
    }
    a:hover { color: blue; text-decoration: underline; }
}
.className{
    width: 120px;
    float:left;
    text-align: center;
}
.classArticle{
    width: 720px;
    padding: 10px 15px;
    float: right;
    a{
        color: black;
    }
}
</style>
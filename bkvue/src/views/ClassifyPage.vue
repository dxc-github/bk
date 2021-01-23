<template>
    <div class="classifypage-parent">
        <div class="classifypage-breadcrumb">
            <breadcrumb></breadcrumb>
        </div>
        <div class="classifypage-class">
            <div class="classifypage-class-item" v-for="(item,i) in articlelist" :key="i">
                <div class="className">
                    <h2>
                        <a href="#">{{item.className}}</a>
                    </h2>
                </div>
                <div class="classArticle">
                    <p v-for="(pitem,j) in item.articles" :key="j">
                        <a href="#">{{pitem.createdate}} {{pitem.articletitle}}</a>
                    </p>
                    <p><a href="#">更多内容...</a></p>
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
                  className:"java",
                  articles:[
                      {
                          articleid:1,
                          articletitle:"java使用Redis集群 封装RedisCluster类",
                          createdate:"2021/10/29"
                      },
                      {
                          articleid:1,
                          articletitle:"java使用Redis集群 封装RedisCluster类",
                          createdate:"2021/10/29"
                      },
                      {
                          articleid:1,
                          articletitle:"java使用Redis集群 封装RedisCluster类",
                          createdate:"2021/10/29"
                      },
                      {
                          articleid:1,
                          articletitle:"java使用Redis集群 封装RedisCluster类",
                          createdate:"2021/10/29"
                      },
                      {
                          articleid:1,
                          articletitle:"java使用Redis集群 封装RedisCluster类",
                          createdate:"2021/10/29"
                      }
                  ]
              },
              {
                  className:"linux",
                  articles:[
                      {
                          articleid:1,
                          articletitle:"linux使用Redis集群 封装RedisCluster类",
                          createdate:"2021/10/29"
                      },
                      {
                          articleid:1,
                          articletitle:"linux使用Redis集群 封装RedisCluster类",
                          createdate:"2021/10/29"
                      },
                      {
                          articleid:1,
                          articletitle:"linux使用Redis集群 封装RedisCluster类",
                          createdate:"2021/10/29"
                      }
                  ]
              },
              {
                  className:"服务器",
                  articles:[
                      {
                          articleid:1,
                          articletitle:"Linux下svn提交版本 post-commit自动同步到网站目录",
                          createdate:"2021/10/29"
                      },
                      {
                          articleid:1,
                          articletitle:"Linux下svn提交版本 post-commit自动同步到网站目录",
                          createdate:"2021/10/29"
                      },
                      {
                          articleid:1,
                          articletitle:"Linux下svn提交版本 post-commit自动同步到网站目录",
                          createdate:"2021/10/29"
                      },
                      {
                          articleid:1,
                          articletitle:"Linux下svn提交版本 post-commit自动同步到网站目录",
                          createdate:"2021/10/29"
                      }
                  ]
              }
          ]
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
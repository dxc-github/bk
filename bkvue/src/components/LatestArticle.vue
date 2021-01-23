<template>
  <div class="latestArticle-parent">
    <div class="latestArticle-title">最新文章</div>
    <div class="latestArticle-content">
      <span
        class="latestArticle-content-item"
        v-for="(item, i) in latestArticles"
        :key="i"
      >
        <a :href="'/list?title='+item.pageid">{{item.pageTitle}}</a>
      </span>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      latestArticles: [
        {
            pageid:1,
            pageTitle:"Linux下svn提交版本 post-commit自动同步到网站目录"
        },
        {
            pageid:2,
            pageTitle:"网页在浏览器或者微信中打开，长按图片会出现菜单如何屏蔽"
        },
        {
            pageid:3,
            pageTitle:"NW.js+GatewayWorker一步步搭建聊天室桌面客户端"
        },
        {
            pageid:4,
            pageTitle:"phpstorm10.0.3破解版安装教程及汉化方法nginx下php无法访问报错Primary script unknown的解决方法"
        },
        {
            pageid:5,
            pageTitle:"解决Nginx出现403 forbidden (13: Permission denied)报错的三种办法The 'Access-Control-Allow-Origin' header contains multiple values '*, *', but only one is allowed."
        },
      ],
    };
  },
};
</script>

<style lang="less">
.latestArticle-parent {
  background: white;
  padding: 10px 0px;
  width: 300px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.latestArticle-title {
  margin: 0px 10px 15px 15px;
  font-size: 15px;
  padding: 5px 0px;
  border-bottom: 0.5px solid rgb(160, 160, 160);
}
.latestArticle-content {
  margin: 10px 15px;
  word-wrap: break-word;
  word-break: break-all;
  span {
    display: block;
    font-size: 12px;
  }
}
</style>
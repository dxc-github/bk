<template>
  <div id="app">
    <div class="home-menu">
      <bkmenu></bkmenu>
    </div>
    <div class="home-page">
      <div class="home-leftpage">
        <router-view></router-view>
      </div>
      <div class="home-rightlist">
        <div class="homerightlist-parent-card">
          <card></card>
        </div>
        <div class="homerightlist-parent-clssify">
          <clssify></clssify>
        </div>
        <div class="homerightlist-parent-labels">
          <labels></labels>
        </div>
        <div class="homerightlist-parent-datecount">
          <datecount></datecount>
        </div>
        <div class="homerightlist-parent-latestArticle">
          <latestArticle></latestArticle>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import bkmenu from "./components/Bkmenu";
import card from "./components/Card";
import clssify from "./components/Classify";
import labels from "./components/Labels.vue";
import datecount from "./components/DateCount";
import latestArticle from "./components/LatestArticle";

export default {
  components: {
    bkmenu,
    card,
    clssify,
    labels,
    datecount,
    latestArticle
  },
};
</script>

<style lang="less">
body {
  background: rgb(230, 230, 230);
}
.home-menu {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  z-index: 10;
}
.home-page {
  width: 1280px;
  margin: 70px auto;
  .home-leftpage {
    float: left;
    overflow:hidden;
    margin-bottom: 50px;
  }
  .home-rightlist {
    float: right;
  }
}
</style>

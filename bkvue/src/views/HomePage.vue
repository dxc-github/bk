<template>
  <div class="homepage-parent">
    <div class="homepage-slideshow">
      <slideshow></slideshow>
    </div>
    <div class="homepage-synopsis" v-if="articlelist">
      <synopsis :articlelist="articlelist"></synopsis>
    </div>
  </div>
</template>

<script>
import slideshow from "../components/Slideshow";
import synopsis from "../components/Synopsis";

export default {
  components: {
    slideshow,
    synopsis,
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

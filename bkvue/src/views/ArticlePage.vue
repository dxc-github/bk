<template>
    <div class="articlepage-parent">
        <div class="articlepage-breadcrumb">
            <breadcrumb></breadcrumb>
        </div>
        <div class="articlepage-article">
            <div class="articlepage-title">
                <h1>{{ article.title }}</h1>
            </div>
            <div class="articlepage-properties">
                <span>
                    <i class="el-icon-edit"></i>
                    {{ article.editDate }}
                </span>
                <span>
                    <i class="el-icon-view"></i>
                    {{ article.views }}
                </span>
                <span>
                    <i class="el-icon-collection-tag"></i>
                    <a href="" v-for="(item,i) in article.label" :key="i">{{ item.labelName }} </a>
                </span>
            </div>
            <div class="articlepage-content">
                <div v-html="htmlstr"></div>
            </div>
        </div>
    </div>
</template>

<script>
import breadcrumb from '../components/Breadcrumb.vue';
export default {
    components:{
        breadcrumb
    },
    data(){
        return{
            article:{
                title:"",
                editDate:"",
                views:0,
                label:[]
            },
            htmlstr:""
        }
    },
    mounted:function(){
        this.getArticle()
    },
    methods:{
        getArticle:function(){
            this.$api.getArticleById(this.$route.query.id)
                .then(
                    (data)=>{
                        console.log(data)
                        this.title=data.result.title
                        this.editDate=data.result.updateTime
                        this.views=data.result.viewCount
                        this.label=data.result.labels
                        this.htmlstr=data.result.context
                    }
                );
        }
    }
}
</script>

<style lang="less">
    .articlepage-article{
        background: white;
        width: 930px;
        padding: 10px 15px;
        margin: 10px 0;
    }
</style>
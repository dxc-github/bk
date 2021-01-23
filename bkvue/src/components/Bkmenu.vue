<template>
    <div class="menu-parent">
        <ul class="menu-ul">
            <li v-for="(item,index) in menus" class="menu-li" :key="index">
                <a :href="item.menuUrl" v-bind:class="{active:active == item.menuName}">{{item.menuName}}</a>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data(){
        return {
            menus:[
                {
                    menuName:"首页",
                    menuUrl:"/"
                },
                {
                    menuName:"文章",
                    menuUrl:"/articles"
                },
                {
                    menuName:"分类",
                    menuUrl:"/classify"
                },
                {
                    menuName:"标签",
                    menuUrl:"/labels"
                },
                {
                    menuName:"归档",
                    menuUrl:"/archive"
                },
                {
                    menuName:"我",
                    menuUrl:"/me"
                },
                {
                    menuName:"留言",
                    menuUrl:"/leaveMessage"
                },
            ],
            active:"首页"
        }
    },
    watch:{
        $route(to,from){
            this.active = this.$route.name
        }
    },
    mounted () {
      this.active = this.$route.name
    },
    methods:{
       
    }
}
</script>

<style lang="less">
    .menu-parent{
        background: white;
        margin: 0;
        padding: 0;
        height: 50px;
        line-height: 50px;
        text-align: center;
    }
    .menu-ul{
        width: 1280px;
        display: inline-block;
        list-style: none;
        margin: 0;
        padding: 0;
    }
    .active{
        font-weight: bold;
    }
    .menu-li{
        float: left;
        margin: 0;
        padding: 0;
        a{
            text-decoration:none;
            font-size: 14px;
            padding: 0px 15px;
            color: black;
            display: block;
        }
        a:hover{
            background: rgb(180, 179, 179);
        }
    }
</style>
<template>
    <div class="card-parent">
        <div class="card-handleimg">
            <img src="" alt="" width="100px" height="100px">
        </div>
        <div class="card-name">董学藏</div>
        <div class="card-center">男，java程序员</div>
        <div class="card-statistics">
            <div class="statistics-text">
                <p>文章</p>
                <p>{{pageSize}}</p>
            </div>
            <div class="statistics-text">
                <p>标签</p>
                <p>{{label}}</p>
            </div>
            <div class="statistics-text">
                <p>热度</p>
                <p>{{heat}}</p>
            </div>
        </div>
        <div class="card-address">
            <i class="el-icon-map-location"></i>
            中国,上海
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return {
            pageSize:500,
            label:60,
            heat:"50W+"
        }
    }
}
</script>

<style lang="less">
    @width:270px;

    .card-parent{
        background: white;
        width: @width;
        height: 305px;
        padding: 10px 15px;
        text-align: center;
        box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    }
    .card-handleimg{
        margin: 0px 10px 15px 15px;
    }
    .card-name{
        width:@width;
        font-size: 18px;
    }
    .card-center{
        width: @width;
        margin: 10px 0px;
        font-size: 10px;
    }
    .statistics-text{
        width: 60px;
        height: 58px;
        float: left;
        width: 33.333%;
    }
    .card-address{
        margin-top: 100px;
        font-size: 15px;
    }

</style>
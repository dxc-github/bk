<template>
  <div class="pagination-parent">
    <div class="pagination-nub">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-size=pagesize
        layout="total, prev, pager, next"
        :total=total>
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
    props:[
        "pagesize",
        "total",
        "defaultpage"
    ],
    data(){
        return {
            
        }
    },
    methods: {
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        this.$parent.CurrentChange(`${val}`)
      }
    }
}
</script>
<style>
.pagination-parent{
  background: white;
  width: 930px;
  padding: 10px 15px;
  margin: 10px 0;
  text-align: center;
}
</style>
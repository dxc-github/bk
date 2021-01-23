<template>
  <div class="archivepage-parent">
    <div class="archivepage-breadcrumb">
      <breadcrumb></breadcrumb>
    </div>
    <div class="archivepage-timeline">
      <el-timeline>
        <el-timeline-item
          :timestamp="item.creatDate"
          placement="top"
          v-for="(item, i) in articlelist"
          :key="i"
        >
          <el-card>
            <h4>
              <a href="">{{ item.className }}</a>
            </h4>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </div>
</template>

<script>
import breadcrumb from "../components/Breadcrumb";

export default {
  components: {
    breadcrumb,
  },
  data() {
    return {
      articlelist: [
        {
          title: "linux",
          className: "Linux Centos6安装php5.6 php7.3多个版本环境",
          creatDate: "2021/10/29",
        },
        {
          title: "linux",
          className: "Linux Centos6安装php5.6 php7.3多个版本环境",
          creatDate: "2021/10/28",
        },
        {
          title: "linux",
          className: "Linux Centos6安装php5.6 php7.3多个版本环境",
          creatDate: "2021/10/27",
        },
        {
          title: "linux",
          className: "Linux Centos6安装php5.6 php7.3多个版本环境",
          creatDate: "2021/10/26",
        },
        {
          title: "linux",
          className: "Linux Centos6安装php5.6 php7.3多个版本环境",
          creatDate: "2021/10/25",
        },
        {
          title: "linux",
          className: "Linux Centos6安装php5.6 php7.3多个版本环境",
          creatDate: "2021/10/24",
        },
        {
          title: "linux",
          className: "Linux Centos6安装php5.6 php7.3多个版本环境",
          creatDate: "2021/10/23",
        },
        {
          title: "linux",
          className: "Linux Centos6安装php5.6 php7.3多个版本环境",
          creatDate: "2021/10/22",
        },
      ],
    };
  },
};
</script>
<style lang="less">
.archivepage-timeline {
  background: white;
  width: 930px;
  padding: 10px 15px;
  margin: 10px 0;
}
.archivepage-timeline {
  a {
    text-decoration: none;
    color: black;
  }
}
</style>
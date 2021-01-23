import Vue from 'vue'
import VueRouter from 'vue-router'
import HomePage from '../views/HomePage.vue';
import ArticleListPage from '../views/ArticleListPage.vue';
import ClassifyPage from '../views/ClassifyPage.vue';
import LabelsPage from '../views/LabelsPage.vue';
import ArchivePage from '../views/ArchivePage.vue';
import UndonePage from '../views/UndonePage.vue';
import Editor from '../components/Editor.vue';
import ArticlePage from '../views/ArticlePage.vue';

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '首页',
    component: HomePage
    // components: {
    //   menu:HomeMenu,
    //   rightList:HomeRightList,
    //   homePage:HomePage
    // }
  },
  {
    path: '/articles',
    name: '文章',
    // props:function(route){
    //   console.log(route)
    //   return {
    //     menuname:"首页",
    //     menuurl:"/ArticleListPage"
    //   }
    // },
    component: ArticleListPage
    // components: {
    //   menu:HomeMenu,
    //   rightList:HomeRightList,
    //   homePage:HomePage
    // }
  },
  {
    path: '/classify',
    name: '分类',
    component: ClassifyPage
  },
  {
    path: '/labels',
    name: '标签',
    component: LabelsPage
  },
  {
    path: '/archive',
    name: '归档',
    component: ArchivePage
  },
  {
    path: '/me',
    name: '我',
    component: UndonePage
  },
  {
    path: '/leaveMessage',
    name: '留言',
    component: UndonePage
  },
  {
    path: '/editor',
    name: '编辑器',
    component: Editor
  },
  {
    path: '/article',
    name: '详情页',
    component: ArticlePage
  },
  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

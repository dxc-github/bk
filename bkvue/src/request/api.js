import {get,post} from './http'

export const api = {
    getArticleList:function(params){
        return get('/api/article/list',params)
    },
    getArticleListByClass:function(id,params){
        return get('/api/article/list/class/'+id,params)
    },
    getArticleListByLabel:function(id,params){
        return get('/api/article/list/label/'+id,params)
    },
    getArticleListByDate:function(date,params){
        return get('/api/article/list/date/'+date,params)
    },
    getArticleDateTotal:function(){
        return get('/api/article/list/dateTotal')
    },
    getArticleById:function(id){
        return get('/api/article/list/'+id)
    },
    getClassList:function(){
        return get('/api/classify/list')
    },
    getLabelList:function(){
        return get('/api/label/list')
    },
    getRecommendList:function(){
        return get('/api/article/list/recommend')
    },
    getClassGroup:function(){
        return get('/api/classify/list/group')
    }
}
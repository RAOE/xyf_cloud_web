import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/login'
import Admin from './views/admin'
import Welcome from './views/admin/welcome.vue'
import Chapter from './views/admin/chapter.vue'

Vue.use(Router)
export default new Router(
    {
        mode: 'history',
        base: process.env.BASE_URL,
        routes: [{
            path: '*',
            redirect: '/login',
        }, {
            path: '/login',
            component: Login
        }, {
            path: '/',
            component: Admin
            , children: [{
                name: 'welcome',
                path: 'welcome',
                component: Welcome,
            }, {
                name: 'business/chapter',
                path: 'business/chapter',
                component: Chapter,
            }]
        }]
    })
import Vue from 'vue';
import TylerPage from './views/TylerPage.vue';
import BikesPage from './views/BikesPage.vue';
import App from './views/App.vue';
import '../assets/app.scss';
import Vuex from 'vuex';
import VueRouter from 'vue-router';

Vue.use(Vuex);
Vue.use(VueRouter);

const store = new Vuex.Store({
    state: {
        count: 0
    },
    mutations: {
        increment(state) {
            state.count++;
        }
    }
});

const routes = [
    { path: '/tyler', component: TylerPage },
    { path: '/bikes', component: BikesPage }
];

const router = new VueRouter({
    routes
});

new Vue({
    store,
    router,
    render: h => h(App)
}).$mount("#app");
import Vue from 'vue';
import TylerPage from './views/TylerPage.vue';
import BikesPage from './views/BikesPage.vue';
import App from './views/App.vue';
import '../assets/app.scss';
import VueRouter from 'vue-router';
import store from "./store";

Vue.use(VueRouter);

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
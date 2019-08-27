import Vue from 'vue';
import Vuex, { StoreOptions } from 'vuex';
import { BaseState } from "@/types";

Vue.use(Vuex);

const store: StoreOptions<BaseState> = {
    state: {
        count: 0
    },
    mutations: {
        increment(state) {
            state.count++;
        }
    }
};

export default new Vuex.Store<BaseState>(store);
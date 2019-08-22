import {createLocalVue, mount} from "@vue/test-utils";
import TylerPantry from "../components/TylerPantry";
import Vuex from 'vuex';

describe('TylerPantry', function () {
    const vue = createLocalVue();
    vue.use(Vuex);

    it('displays food', () => {
        const app = mount(TylerPantry, {
            vue,
            mocks: {
                $store: {
                    state: { count: 1 }
                }
            },
            propsData: {
                food: 'pear'
            }
        });

        expect(app.text()).toContain('I like pear')
    });
});

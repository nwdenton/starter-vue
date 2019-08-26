import {mount} from "@vue/test-utils";
import TylerPantry from "../components/TylerPantry.vue";

describe('TylerPantry', function () {
    it('displays food', () => {
        const app = mount(TylerPantry, {
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

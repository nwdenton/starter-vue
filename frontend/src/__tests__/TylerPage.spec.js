import {shallowMount, createLocalVue} from "@vue/test-utils";
import TylerPage from '../views/TylerPage';

describe('TylerPantry', function () {
    it('has centered stuff', () => {
        const vue = createLocalVue();

        const wrapper = shallowMount(TylerPage, {vue});

        expect(wrapper.classes()).toContain('center-content')
    });
});

import { shallowMount } from "@vue/test-utils";
import TylerPage from '@views/TylerPage.vue';

describe('TylerPantry', () => {
    it('has centered stuff', () => {
        const wrapper = shallowMount(TylerPage, {});

        expect(wrapper.classes()).toContain('center-content')
    });
});

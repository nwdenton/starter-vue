<template>
    <div class="full-width center-content">
        <div>
            <h1>HEY Tyler!</h1>
            <input :value="tylersFood"/>
            <tyler-pantry :food="tylersFood"></tyler-pantry>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import Component from 'vue-class-component';
    import TylerPantry from '../components/TylerPantry.vue';

    @Component({
        components: { TylerPantry }
    })
    export default class TylerPage extends Vue {
        tylersFood: string;

        constructor() {
            super();
            this.tylersFood = 'apple';
        }
    }
</script>
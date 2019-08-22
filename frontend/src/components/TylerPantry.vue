<template>
    <div>
        <h1>I'm Tyler and I like {{ food }}</h1>
        <h2>I have {{this.$store.state.count}} of them</h2>
        <button @click="updateCount">MO {{ food }}</button>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import Component from 'vue-class-component';
    import { Prop } from 'vue-property-decorator';

    @Component({})
    export default class TylerPantry extends Vue {
        @Prop()
        food!: string;

        updateCount() {
            this.$store.commit('increment');
        }
    }
</script>
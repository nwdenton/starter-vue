<template>
    <div>
        <router-link to="/tyler">Go to Tyler</router-link>
        <router-link to="/bikes">Go to Bikes</router-link>
       <router-view/>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import Component from 'vue-class-component';

    @Component({})
    export default class App extends Vue {}
</script>
<template>
    <div>
        <label v-if="!!userName">{{userName}}</label>
        <router-link to="/tyler">Go to Tyler</router-link>
        <router-link to="/bikes">Go to Bikes</router-link>
        <router-view/>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import client from '../client'
    import Component from 'vue-class-component';

    @Component({})
    export default class App extends Vue {
        userName: string;

        constructor() {
            super();
            this.userName = '';
        }

        async created() {
            client.get('/api/whoami')
                .then(response => {
                    if (response.status < 400) {
                        this.userName = response.data.name;

                        return
                    }

                    throw new Error()
                })
                .catch(() => {
                })
        }
    }
</script>
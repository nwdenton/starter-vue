<template>
    <div>
        <h1>Hello MAESTRO!</h1>
        <div>
            <label v-if="!!userName">User: {{userName}}</label>
        </div>
        <div>
            <router-link to="/tyler">Go to Tyler</router-link>
            <router-link to="/bikes">Go to Bikes</router-link>
            <router-view/>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import axios from 'axios';
    import Component from 'vue-class-component';

    @Component({})
    export default class App extends Vue {
        userName: string;

        constructor() {
            super();
            this.userName = '';
        }

        async created() {
            axios.get('/api/whoami')
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
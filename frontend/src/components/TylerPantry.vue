<template>
    <div>
        <h1>I'm Tyler and I like {{ food }}</h1>
        <h2>I have {{this.$store.state.count}} of them</h2>
        <button @click="updateCount">MO {{ food }}</button>
    </div>
</template>

<script>
    export default {
        props: {
            food: {
                type: String,
                required: true
            }
        },
        methods: {
            updateCount() {
                this.$store.commit('increment');
            }
        }
    }
</script>
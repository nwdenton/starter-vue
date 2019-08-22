<template>
    <div class="full-width center-content">
        <div>
            <h1>HEY Tyler!</h1>
            <input :value="tylersFood" @change="changeFood" />
            <tyler-pantry :food="tylersFood"></tyler-pantry>
        </div>
    </div>
</template>

<script>
    import TylerPantry from '../components/TylerPantry.vue'

    export default {
        data: function () {
            return {
                tylersFood: 'apple'
            }
        },
        components: {
            TylerPantry: TylerPantry
        },
        methods: {
            changeFood(e) {
                this.tylersFood = e.target.value;
            }
        }
    }
</script>
<template>
    <div>
        <h1>现在你可以为所欲为了！</h1>
    </div>
</template>
<script>
    export default {
        name: 'login',
        mounted: function () {
            this.$parent.activeSidebar("welcome-sidebar");
        },
        methods: {
            login() {
                this.$router.push("/welcome");
            }
        }
    }
</script>

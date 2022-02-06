import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
export const state = () => ({
    records: []
})

export const mutations = {
    changeRecords(state, data) {
        state.records = [];
        state.records = data;
    }
}
export const actions = {
    async getRecords( {commit},params) {
        let result = await this.$axios.get("/api/v1/getAllRecords");
        console.log(result);
        commit("changeRecords",result.data);
    }
}
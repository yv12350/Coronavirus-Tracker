<template>
  <v-row>
    <v-col cols="12">
      <v-card>
        
        <v-card-title> Coronavirus Tracker </v-card-title>
         <v-text-field
          v-model="search"
          label="Search"
          class="mx-4"
        ></v-text-field>
        <v-data-table
          :headers="headers"
          :items="returnRecords"
          :items-per-page="10"
          :search="search"
          class="elevation-1"
        ></v-data-table>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import axios from "Axios";
export default {
  data() {
    return {
      search:"",
      headers: [
        {
          text: "Country",
          align: "start",
          sortable: false,
          value: "country",
        },
        {
          text: "State",
          value: "state",
        },
        {
          text: "Cases Today",
          value: "casesToday",
        },
      ],
    };
  },
  mounted() {
    this.getRecords();
  },
  computed: {
    returnRecords() {
      return this.$store.state.records;
    },
  },
  methods: {
    async getRecords() {
      this.$store.dispatch("getRecords", {});
    },
  },
};
</script>

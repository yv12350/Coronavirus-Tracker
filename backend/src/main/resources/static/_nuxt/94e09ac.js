(window.webpackJsonp=window.webpackJsonp||[]).push([[6],{471:function(e,t,r){"use strict";r.r(t);var n=r(16),c=(r(79),r(378),{data:function(){return{search:"",headers:[{text:"Country",align:"start",sortable:!1,value:"country"},{text:"State",value:"state"},{text:"Cases Today",value:"casesToday"}]}},mounted:function(){this.getRecords()},computed:{returnRecords:function(){return this.$store.state.records}},methods:{getRecords:function(){var e=this;return Object(n.a)(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:e.$store.dispatch("getRecords",{});case 1:case"end":return t.stop()}}),t)})))()}}}),o=r(80),l=r(126),d=r.n(l),v=r(360),h=r(366),f=r(468),m=r(470),w=r(469),x=r(463),component=Object(o.a)(c,(function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("v-row",[r("v-col",{attrs:{cols:"12"}},[r("v-card",[r("v-card-title",[e._v(" Coronavirus Tracker ")]),e._v(" "),r("v-text-field",{staticClass:"mx-4",attrs:{label:"Search"},model:{value:e.search,callback:function(t){e.search=t},expression:"search"}}),e._v(" "),r("v-data-table",{staticClass:"elevation-1",attrs:{headers:e.headers,items:e.returnRecords,"items-per-page":10,search:e.search}})],1)],1)],1)}),[],!1,null,null,null);t.default=component.exports;d()(component,{VCard:v.a,VCardTitle:h.a,VCol:f.a,VDataTable:m.a,VRow:w.a,VTextField:x.a})}}]);
<template>
    <div class="homerightlist-parent">
      <div class="homerightlist-parent-card">
          <card></card>
      </div>
      <div class="homerightlist-parent-clssify">
          <clssify></clssify>
      </div>
      <div class="homerightlist-parent-labels">
          <labels></labels>
      </div>
      <div class="homerightlist-parent-datecount">
          <datecount></datecount>
      </div>
      <div class="homerightlist-parent-latestpage">
          <latestpage></latestpage>
      </div>
    </div>
</template>

<script>
import card from '../components/Card';
import clssify from '../components/Classify';
import labels from '../components/Labels';
import datecount from '../components/DateCount';
import latestpage from '../components/LatestPage';

export default {
    components:{
        card,
        clssify,
        labels,
        datecount,
        latestpage
    }
}
</script>



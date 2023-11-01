module eu.bopet.jocadv.core.core {
    requires commons.math3;
    requires org.apache.commons.lang3;

    exports eu.bopet.jocadv.core.constraints.regenerative.axis;
    exports eu.bopet.jocadv.core.constraints.regenerative.cosys;
    exports eu.bopet.jocadv.core.constraints.regenerative.exception;
    exports eu.bopet.jocadv.core.constraints.regenerative.feature;
    exports eu.bopet.jocadv.core.constraints.regenerative.plane;
    exports eu.bopet.jocadv.core.constraints.regenerative.point;
    exports eu.bopet.jocadv.core.constraints.regenerative.sketch;
    exports eu.bopet.jocadv.core.constraints.regenerative.vector;
    exports eu.bopet.jocadv.core.constraints.sketch;
    exports eu.bopet.jocadv.core.features;
    exports eu.bopet.jocadv.core.features.basic;
    exports eu.bopet.jocadv.core.features.datums;
    exports eu.bopet.jocadv.core.features.exception;
    exports eu.bopet.jocadv.core.features.protrusion;
    exports eu.bopet.jocadv.core.features.sketch;
    exports eu.bopet.jocadv.ie.step;
    exports eu.bopet.jocadv.ie.step.exception;
    exports eu.bopet.jocadv.core.features.basic.curve;
    exports eu.bopet.jocadv.core.features.surface;
}
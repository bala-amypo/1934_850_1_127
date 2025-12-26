-- Severity Weights
INSERT INTO priority_rule (type, level, weight, description) VALUES ('SEVERITY', 'CRITICAL', 5.0, 'Critical');
INSERT INTO priority_rule (type, level, weight, description) VALUES ('SEVERITY', 'HIGH', 3.0, 'High');
INSERT INTO priority_rule (type, level, weight, description) VALUES ('SEVERITY', 'MEDIUM', 2.0, 'Medium');
INSERT INTO priority_rule (type, level, weight, description) VALUES ('SEVERITY', 'LOW', 1.0, 'Low');

-- Urgency Weights
INSERT INTO priority_rule (type, level, weight, description) VALUES ('URGENCY', 'IMMEDIATE', 5.0, 'Immediate');
INSERT INTO priority_rule (type, level, weight, description) VALUES ('URGENCY', 'HIGH', 3.0, 'High');
INSERT INTO priority_rule (type, level, weight, description) VALUES ('URGENCY', 'MEDIUM', 2.0, 'Medium');
INSERT INTO priority_rule (type, level, weight, description) VALUES ('URGENCY', 'LOW', 1.0, 'Low');

-- Category Weights (for ComplaintPriorityRules table)
INSERT INTO complaint_priority_rules (category, base_weight) VALUES ('Security', 2.0);
INSERT INTO complaint_priority_rules (category, base_weight) VALUES ('Technical', 1.5);
INSERT INTO complaint_priority_rules (category, base_weight) VALUES ('Billing', 1.2);
INSERT INTO complaint_priority_rules (category, base_weight) VALUES ('General', 1.0);
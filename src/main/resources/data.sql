-- Severity Weights
INSERT IGNORE INTO priority_rule (type, level, weight, description, active) VALUES ('SEVERITY', 'CRITICAL', 5.0, 'Critical', true);
INSERT IGNORE INTO priority_rule (type, level, weight, description, active) VALUES ('SEVERITY', 'HIGH', 3.0, 'High', true);
INSERT IGNORE INTO priority_rule (type, level, weight, description, active) VALUES ('SEVERITY', 'MEDIUM', 2.0, 'Medium', true);
INSERT IGNORE INTO priority_rule (type, level, weight, description, active) VALUES ('SEVERITY', 'LOW', 1.0, 'Low', true);

-- Urgency Weights
INSERT IGNORE INTO priority_rule (type, level, weight, description, active) VALUES ('URGENCY', 'IMMEDIATE', 5.0, 'Immediate', true);
INSERT IGNORE INTO priority_rule (type, level, weight, description, active) VALUES ('URGENCY', 'HIGH', 3.0, 'High', true);
INSERT IGNORE INTO priority_rule (type, level, weight, description, active) VALUES ('URGENCY', 'MEDIUM', 2.0, 'Medium', true);
INSERT IGNORE INTO priority_rule (type, level, weight, description, active) VALUES ('URGENCY', 'LOW', 1.0, 'Low', true);

-- Category Weights
INSERT IGNORE INTO complaint_priority_rules (category, base_weight) VALUES ('Security', 2.0);
INSERT IGNORE INTO complaint_priority_rules (category, base_weight) VALUES ('Technical', 1.5);
INSERT IGNORE INTO complaint_priority_rules (category, base_weight) VALUES ('Billing', 1.2);
INSERT IGNORE INTO complaint_priority_rules (category, base_weight) VALUES ('General', 1.0);
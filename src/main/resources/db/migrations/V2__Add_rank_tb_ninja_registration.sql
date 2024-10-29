-- V2: Migration to add column RANK on TB_REGISTRATION
ALTER TABLE tb_ninja_registration
ADD COLUMN rank VARCHAR(255);
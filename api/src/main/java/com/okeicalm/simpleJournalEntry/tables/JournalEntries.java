/*
 * This file is generated by jOOQ.
 */
package com.okeicalm.simpleJournalEntry.tables;


import com.okeicalm.simpleJournalEntry.Indexes;
import com.okeicalm.simpleJournalEntry.Keys;
import com.okeicalm.simpleJournalEntry.SimpleJournalEntryDb;
import com.okeicalm.simpleJournalEntry.tables.records.JournalEntriesRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JournalEntries extends TableImpl<JournalEntriesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of
     * <code>simple_journal_entry_db.journal_entries</code>
     */
    public static final JournalEntries JOURNAL_ENTRIES = new JournalEntries();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JournalEntriesRecord> getRecordType() {
        return JournalEntriesRecord.class;
    }

    /**
     * The column <code>simple_journal_entry_db.journal_entries.id</code>.
     */
    public final TableField<JournalEntriesRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column
     * <code>simple_journal_entry_db.journal_entries.journal_id</code>.
     */
    public final TableField<JournalEntriesRecord, Long> JOURNAL_ID = createField(DSL.name("journal_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>simple_journal_entry_db.journal_entries.side</code>.
     */
    public final TableField<JournalEntriesRecord, Byte> SIDE = createField(DSL.name("side"), SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column
     * <code>simple_journal_entry_db.journal_entries.account_id</code>.
     */
    public final TableField<JournalEntriesRecord, Long> ACCOUNT_ID = createField(DSL.name("account_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>simple_journal_entry_db.journal_entries.value</code>.
     */
    public final TableField<JournalEntriesRecord, Integer> VALUE = createField(DSL.name("value"), SQLDataType.INTEGER.nullable(false), this, "");

    private JournalEntries(Name alias, Table<JournalEntriesRecord> aliased) {
        this(alias, aliased, null);
    }

    private JournalEntries(Name alias, Table<JournalEntriesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>simple_journal_entry_db.journal_entries</code>
     * table reference
     */
    public JournalEntries(String alias) {
        this(DSL.name(alias), JOURNAL_ENTRIES);
    }

    /**
     * Create an aliased <code>simple_journal_entry_db.journal_entries</code>
     * table reference
     */
    public JournalEntries(Name alias) {
        this(alias, JOURNAL_ENTRIES);
    }

    /**
     * Create a <code>simple_journal_entry_db.journal_entries</code> table
     * reference
     */
    public JournalEntries() {
        this(DSL.name("journal_entries"), null);
    }

    public <O extends Record> JournalEntries(Table<O> child, ForeignKey<O, JournalEntriesRecord> key) {
        super(child, key, JOURNAL_ENTRIES);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : SimpleJournalEntryDb.SIMPLE_JOURNAL_ENTRY_DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.JOURNAL_ENTRIES_FK_ACCOUNT, Indexes.JOURNAL_ENTRIES_FK_JOURNAL);
    }

    @Override
    public Identity<JournalEntriesRecord, Long> getIdentity() {
        return (Identity<JournalEntriesRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<JournalEntriesRecord> getPrimaryKey() {
        return Keys.KEY_JOURNAL_ENTRIES_PRIMARY;
    }

    @Override
    public List<ForeignKey<JournalEntriesRecord, ?>> getReferences() {
        return Arrays.asList(Keys.JOURNAL_ENTRIES_IBFK_1, Keys.JOURNAL_ENTRIES_IBFK_2);
    }

    private transient Journals _journals;
    private transient Accounts _accounts;

    public Journals journals() {
        if (_journals == null)
            _journals = new Journals(this, Keys.JOURNAL_ENTRIES_IBFK_1);

        return _journals;
    }

    public Accounts accounts() {
        if (_accounts == null)
            _accounts = new Accounts(this, Keys.JOURNAL_ENTRIES_IBFK_2);

        return _accounts;
    }

    @Override
    public JournalEntries as(String alias) {
        return new JournalEntries(DSL.name(alias), this);
    }

    @Override
    public JournalEntries as(Name alias) {
        return new JournalEntries(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JournalEntries rename(String name) {
        return new JournalEntries(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JournalEntries rename(Name name) {
        return new JournalEntries(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, Byte, Long, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}

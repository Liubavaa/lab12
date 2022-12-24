package task2;

import lombok.SneakyThrows;

public class CachedDocument {
    public String gcsPath;
    private final Database database;

    public CachedDocument(String gcsPath) {
        this.gcsPath = gcsPath;
        this.database = Database.getInstance();
    }

    @SneakyThrows
    public String parse(){
        String sql = String.format("SELECT * FROM DOCUMENT where gscPath=%s", gcsPath);
        String qRes = database.query(sql);
        if (qRes == null){
            Document document = new SmartDocument(gcsPath);
            String result = document.parse();
            String upd = String.format("insert into document (gscPath, document) values ('%s', '%s');", gcsPath, result);
            database.update(upd);
            return result;
        }
        return qRes;
    }
}

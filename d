diff --git a/bin/Cluedo/Person.class b/bin/Cluedo/Person.class
deleted file mode 100644
index e614bed..0000000
Binary files a/bin/Cluedo/Person.class and /dev/null differ
diff --git a/src/Cluedo/Person.java b/src/Cluedo/Person.java
deleted file mode 100644
index 062d730..0000000
--- a/src/Cluedo/Person.java
+++ /dev/null
@@ -1,40 +0,0 @@
-package Cluedo;
-
-public class Person implements Card {
-	private String name;
-
-	public Person(String name) {
-		this.name = name;
-	}
-	
-	@Override
-	public String getName() {
-		return this.name;
-	}
-
-	@Override
-	public int hashCode() {
-		final int prime = 31;
-		int result = 1;
-		result = prime * result + ((name == null) ? 0 : name.hashCode());
-		return result;
-	}
-
-	@Override
-	public boolean equals(Object obj) {
-		if (this == obj)
-			return true;
-		if (obj == null)
-			return false;
-		if (getClass() != obj.getClass())
-			return false;
-		Person other = (Person) obj;
-		if (name == null) {
-			if (other.name != null)
-				return false;
-		} else if (!name.equals(other.name))
-			return false;
-		return true;
-	}
-
-}

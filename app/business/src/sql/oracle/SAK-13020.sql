update GB_GRADABLE_OBJECT_T set DUE_DATE = DUE_DATE + (86399/86400) where DUE_DATE is not null;